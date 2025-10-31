CREATE DATABASE IF NOT EXISTS fruit_shop;
USE fruit_shop;
-- them khoa
-- Thêm FK order_id tham chiếu Orders
ALTER TABLE OrderDetail
ADD CONSTRAINT fk_order
FOREIGN KEY (order_id) REFERENCES Orders(order_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

-- Thêm FK fruit_id tham chiếu Fruit
ALTER TABLE OrderDetail
ADD CONSTRAINT fk_fruit
FOREIGN KEY (fruit_id) REFERENCES Fruit(fruit_id)
ON DELETE CASCADE
ON UPDATE CASCADE;
