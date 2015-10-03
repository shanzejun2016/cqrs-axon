DROP TABLE IF EXISTS `ca_catalog`;

CREATE TABLE `ca_catalog` (
  `id` varchar(160) NOT NULL,
  `name` varchar(160) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_NAME_CA_CATALOG` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `ca_product`;

CREATE TABLE `ca_product` (
  `id` varchar(160) NOT NULL,
  `name` varchar(160) NOT NULL,
  `archived` bit(1) DEFAULT b'0',
  `manufacturer` varchar(160) DEFAULT NULL,
  `model` varchar(160) DEFAULT NULL,
  `catalog_id` varchar(160) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_NAME_CA_PRODUCT` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `ca_product` ADD CONSTRAINT `FK_PRODUCT_CATALOG` FOREIGN KEY (`catalog_id`) REFERENCES `ca_catalog` (`id`) ON UPDATE CASCADE ON DELETE NO ACTION;


DROP TABLE IF EXISTS `ca_inventory`;

CREATE TABLE `ca_inventory` (
	`id` int(11) NOT NULL,
	`product_id` varchar(160) NOT NULL,
	`quantity` int(11) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `ca_inventory` ADD CONSTRAINT `FK_INVENTORY_PRODUCT` FOREIGN KEY (`product_id`) REFERENCES `ca_product` (`id`) ON UPDATE CASCADE ON DELETE NO ACTION;

	



