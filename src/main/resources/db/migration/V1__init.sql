CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255) NOT NULL,
                       name VARCHAR(100) NOT NULL,
                       created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

                       CONSTRAINT uk_users_email UNIQUE (email)
);


CREATE TABLE orders (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        user_id BIGINT NOT NULL,
                        status VARCHAR(20) NOT NULL DEFAULT 'NEW',
                        total_amount DECIMAL(12, 2) NOT NULL,
                        created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
                            ON UPDATE CURRENT_TIMESTAMP,
                        version INT NOT NULL DEFAULT 0,

                        CONSTRAINT fk_orders_user
                            FOREIGN KEY (user_id)
                                REFERENCES users (id),

                        CONSTRAINT chk_orders_status
                            CHECK (status IN ('NEW', 'PAID', 'SHIPPED', 'CANCELLED')),

                        CONSTRAINT chk_orders_total_amount
                            CHECK (total_amount >= 0),

                        INDEX idx_orders_user_id (user_id),
                        INDEX idx_orders_status_created_at (status, created_at)
);


CREATE TABLE order_items (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             order_id BIGINT NOT NULL,
                             sku VARCHAR(50) NOT NULL,
                             qty INT NOT NULL,
                             price DECIMAL(12, 2) NOT NULL,

                             CONSTRAINT fk_order_items_order
                                 FOREIGN KEY (order_id)
                                     REFERENCES orders (id),

                             CONSTRAINT chk_order_items_qty
                                 CHECK (qty > 0),

                             CONSTRAINT chk_order_items_price
                                 CHECK (price >= 0),

                             INDEX idx_order_items_order_id (order_id)
);


CREATE TABLE idempotency_keys (
                                  idem_key VARCHAR(100) PRIMARY KEY,
                                  order_id BIGINT NOT NULL,
                                  response_body JSON NOT NULL,
                                  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

                                  CONSTRAINT fk_idempotency_keys_order
                                      FOREIGN KEY (order_id)
                                          REFERENCES orders (id)
);


CREATE TABLE outbox_events (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               event_id CHAR(36) NOT NULL,
                               aggregate_type VARCHAR(50) NOT NULL,
                               aggregate_id BIGINT NOT NULL,
                               event_type VARCHAR(50) NOT NULL,
                               payload JSON NOT NULL,
                               status VARCHAR(10) NOT NULL DEFAULT 'NEW',
                               created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               sent_at DATETIME NULL,

                               CONSTRAINT uk_outbox_events_event_id
                                   UNIQUE (event_id),

                               CONSTRAINT chk_outbox_events_status
                                   CHECK (status IN ('NEW', 'SENT', 'FAILED')),

                               INDEX idx_outbox_events_status_created_at (status, created_at)
);
