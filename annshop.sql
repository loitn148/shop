<<<<<<< HEAD
/*
MySQL Backup
Database: annshop
Backup Time: 2018-06-15 13:56:29
*/

=======
/*
MySQL Backup
Database: annshop
Backup Time: 2018-06-15 13:56:29
*/

>>>>>>> b2797cac5293be8f2b40dac24ebf2531f682681d
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `annshop`.`bill`;
DROP TABLE IF EXISTS `annshop`.`bill_details`;
DROP TABLE IF EXISTS `annshop`.`category`;
DROP TABLE IF EXISTS `annshop`.`p_gallery`;
DROP TABLE IF EXISTS `annshop`.`product`;
DROP TABLE IF EXISTS `annshop`.`users`;
CREATE TABLE `bill` (
  `id` bigint(32) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `owner` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total` double(32,0) DEFAULT NULL,
  `payment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `note` longtext COLLATE utf8_unicode_ci,
  `status` int(11) DEFAULT '0',
  `checkout` int(11) DEFAULT '0',
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `bill_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_id` bigint(32) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `price` double(32,0) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `category` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Category ID',
  `cat_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cat_parent_id` int(11) DEFAULT NULL,
  `slug` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `p_gallery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `image_gallery` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `product_price` double(32,0) DEFAULT NULL,
  `product_discount` double(32,0) DEFAULT NULL,
  `product_description` longtext COLLATE utf8_unicode_ci,
  `product_image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_slug` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_price_sale` double(32,0) DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` int(11) DEFAULT '0',
  `token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
BEGIN;
LOCK TABLES `annshop`.`bill` WRITE;
DELETE FROM `annshop`.`bill`;
INSERT INTO `annshop`.`bill` (`id`,`user_id`,`owner`,`address`,`phone`,`total`,`payment`,`date`,`note`,`status`,`checkout`,`email`) VALUES (1528714015372, 1, 'Tr·ª?nh Ng·ªçc L·ª£i', '69/8, ƒ?∆∞·ªùng 120, ph∆∞·ªùng T√¢n Ph√∫, qu·∫≠n Th·ªß ƒê·ª©c, TP. HCM', '968758732', 6, 'COD', '2018-06-11 17:46:55', '', 0, 0, 'loitn148@gmail.com'),(1528714222722, 1, '', '', '', 47, 'COD', '2018-06-11 17:50:23', '', 0, 0, ''),(1528714267779, 1, 'LOI TRINH NGOC', '123124', '968758732', 47, 'BASC', '2018-06-11 17:51:08', 'afasdgasg ', 0, 0, 'loitn148@gmail.com');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `annshop`.`bill_details` WRITE;
DELETE FROM `annshop`.`bill_details`;
INSERT INTO `annshop`.`bill_details` (`id`,`bill_id`,`product_id`,`price`,`quantity`) VALUES (4, 1528714015372, 2, 6, 1),(5, 1528714222722, 17, 47, 1),(6, 1528714267779, 17, 47, 1);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `annshop`.`category` WRITE;
DELETE FROM `annshop`.`category`;
INSERT INTO `annshop`.`category` (`cat_id`,`cat_name`,`cat_parent_id`,`slug`) VALUES (1, 'Skincare', 0, 'skincare'),(2, 'Lipstick', 0, 'lipstick'),(3, 'Moisturizer', 1, 'moisturizer'),(4, 'Cleanser', 1, 'cleanser'),(5, 'Sunscreen', 1, 'sunscreen'),(6, 'Treatments', 1, 'treatments'),(7, 'Toner', 1, 'toner'),(8, 'Fragrance', 0, 'fragrance');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `annshop`.`p_gallery` WRITE;
DELETE FROM `annshop`.`p_gallery`;
INSERT INTO `annshop`.`p_gallery` (`id`,`product_id`,`image_gallery`) VALUES (1, 2, '../gallery/s1_pd_2.jpg'),(2, 4, '../gallery/s1_pd_4.jpg'),(3, 4, '../gallery/s2_pd_4.jpg'),(4, 5, '../gallery/s1_pd_5.jpg'),(5, 6, '../gallery/s1_pd_6.jpg'),(6, 6, '../gallery/s2_pd_6.jpg'),(7, 7, '../gallery/s1_pd_7.jpg'),(8, 8, '../gallery/s1_pd_8.jpg'),(9, 9, '../gallery/s1_pd_9.jpg'),(10, 9, '../gallery/s2_pd_9.jpg'),(11, 10, '../gallery/s1_pd_10.jpg'),(12, 11, '../gallery/s1_pd_11.jpg'),(13, 12, '../gallery/s1_pd_12.jpg'),(14, 12, '../gallery/s2_pd_12.jpg'),(15, 12, '../gallery/s3_pd_12.jpg'),(16, 13, '../gallery/s1_pd_13.jpg'),(17, 13, '../gallery/s2_pd_13.jpg'),(18, 14, '../gallery/s1_pd_14.jpg'),(19, 14, '../gallery/s2_pd_14.jpg'),(20, 15, '../gallery/s1_pd_15.jpg'),(21, 15, '../gallery/s2_pd_15.jpg'),(22, 16, '../gallery/s1_pd_16.jpg'),(23, 16, '../gallery/s2_pd_16.jpg'),(24, 16, '../gallery/s3_pd_16.jpg'),(25, 18, '../gallery/s1_pd_18.jpg'),(26, 18, '../gallery/s2_pd_18.jpg');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `annshop`.`product` WRITE;
DELETE FROM `annshop`.`product`;
INSERT INTO `annshop`.`product` (`product_id`,`product_name`,`cat_id`,`product_price`,`product_discount`,`product_description`,`product_image`,`product_slug`,`product_price_sale`) VALUES (1, 'Aveeno Positively Radiant Skin Brightening Exfoliating', 3, 10, 10, 'Today I will continue to review a product that has been recommended by dermatologists and pediatricians for its safety and efficacy, which are products under the Aveeno brand ñ AVEENO POSITIVELY. RADIANT SKIN BRIGHTENING DAILY SCRUB', '../images/pd_1.jpg', 'aveeno-positively-radiant-skin-brightening-exfoliating', 9),(2, 'Avene Very High Protection Cream SPF 50', 5, 7, 10, 'Knowing as the top skin care product in France, Avene is recommended by many famous dermatologists in the world. Based on the mineral spring on the Black Mountain in western France, Avene is considered a brand with benign products including sensitive skin, which treats many serious skin diseases with natural ingredients.', '../images/pd_2.jpg', 'avene-very-high-protection-cream-spf-50', 6),(3, 'Clean Clear Advantage Treatment Medication', 3, 20, 5, 'Hello you guys, Today I will review a gel acne treatment has been born for a long time but still on the list of good acne products, which is Clean & Clear Advantage Acne Spot Treatment, Salicylic Acid Acne Medication.', '../images/pd_3.jpg', 'clean-clear-advantage-treatment-medication', 19),(4, 'Clinique Acne Solutions Acne/Line Correcting Serum', 6, 50, 20, 'Clinique Acne Solutions Acne + Line Correcting Serum is designed with the blue glass bottle, which is small but neat features of the company. The product can be used for all skin types, from oily to dry skin and we do not need to worry about allergies to the product. The main ingredient is Slicylic Acid, one of the great antimicrobial ingredients that can reduce acne, blackheads. In addition, the product is added Hylalunonic Acid to moisturize the skin so as to avoid dryness to your skin.', '../images/pd_4.jpg', 'clinique-acne-solutions-acne-line-correcting-serum', 40),(5, 'Clinique Dramatically Different Moisturizing Lotion+', 3, 20, 5, 'Was born in 1968, and to date Clinique has confirmed its brand in the worldís leading skin care formula. †With all , The iconic DDML formula has remained the same despite any technological advances in skincare and been wholly impervious to beauty trends, and with good reason ñ itís been the worldís best-selling premium skincare product for donkeyís years.', '../images/pd_5.jpg', 'clinique-dramatically-different-moisturizing-lotion', 19),(6, 'ESTEE LAUDER Advanced Night Repair Recovery Complex Ii', 3, 100, 10, 'The first product I spoke of was the best-selling product of the brand, which first appeared in the eighties and is still the top choice for beauty enthusiasts ñ Estee Lauder Advanced Night Repair Serum (ANR), the brand of Estee Lauder.', '../images/pd_6.jpg', 'lauder-advanced-repair-recovery-complex', 90),(7, 'Kiehlís Midnight Recovery Concentrate', 3, 10, 5, 'In recent years, beauty followers have become more interested in skin care products for the night because, as we all know, night time is the best stage of skin regeneration, Hotter than the day, the skin absorbs vitamins, fatty acids in the oil better than the daytime.', '../images/pd_7.jpg', 'kiehls-midnight-recovey-concentrate', 9),(8, 'Kiehlís Rare Earth Deep Pore Cleansing Masque 5fl.oz 142g', 4, 50, 10, 'When you visit Kiehlís home page you will see a red print for this product:†A cleansing masque that helps to purify skin and visibly minimize pores.†The main ingredient is the Amazonian White Clay that gently sucks away excess oil, dirt and pores, so it has a significant reduction in pore size ñ This is a remarkable effect recognized by the beauty review all around the world. In addition, the addition of barley and aloe vera to enhance the skin, prevent skin to dry skin.', '../images/pd_8.jpg', 'kiehls-rare-earth-deep-pore-cleansing-masque', 45),(9, 'La Roche Rosay Anthelios XL Ultra Light Fluid 50', 5, 10, 0, 'Anthelios Fliud SPF 50+ is a product that is equipped with a variety of sunscreen ingredients, including the main ingredient is Mexoplex filter ñ unique Thermal Spring Water and Mexoryl XL to protect skin cells for a youthful, glowing complexion. other ingredients such as Butyl Mathoxydibenzoylmathane. Anthelios also contains silica oil, Glycerin helps moisturize the skin. This is considered the most outstanding product of La Roche-Posay,', '../images/pd_9.jpg', 'la-roche-rosay-anthelios-xl-ultra-light-fluid-50', 10),(10, 'La Roche-Posay Anthelios Clear Skin Face Sunscreen', 5, 80, 10, 'We are no stranger to the product line of La Roche ñ Posay, a famous brand for acne treatment products, very suitable for sensitive skin. And if youíre looking for a sunscreen for oily and acne skin, Anthelios is the best choice you have been seen. Anthelios Clear Skin Dry Touch Sunscreen Broad Spectrum SPF 60 comes in opaque, squeeze tube packaging, which helps preserve the stability of the formula. True to claims, it contains ingredients that mattify/prevent oily shine (at least temporarilyóa few hours per use) and its tenacious formula can withstand hot, humid conditions better than most (but youíll still need to reapply if you perspire heavily).', '../images/pd_10.jpg', 'la-roche-posay-anthelios-clear-skin-face-sunscreen-for-oily-skin-spf-60-oil-free-dry-touch-sunscreen-water-resistant-1-7-fl-oz', 72),(11, 'Neutrogena Hydro Boost Hyaluronic Acid Hydrating Face Moisturizer Gel-Cream', 3, 10, 0, 'Itís one of many products winning and best selling water gel formula absorbs quickly and instantly delivers intense hydration. Applies effortlessly, absoring quickly unto skin without leaving behind an oily or greasy.', '../images/pd_11.jpg', 'neutrogena-hydro-boost-hyaluronic-acid-hydrating-face-moisturizer-gel-cream-to-hydrate-and-smooth-extra-dry-skin-1-7-oz', 10),(12, 'Neutrogena Oil-Free Acne Wash Redness Soothing Facial Cleaners With Salicylic Acid', 4, 22, 10, 'Neutrogena Oil ñ Free Ace Wash Redness Soothing Facial Cleanser has been certified by the worldís leading dermatologists to reduce 90% of oily and oily skin, which is the main cause of blackheads formation on your face, worthy of being the most famous brand in acne treatment.', '../images/pd_12.jpg', 'neutrogena-oil-free-soothing-cleaners-salicylic', 20),(13, 'Shouhengda Blackhead Remover Cream Purifying', 6, 40, 10, 'If you have blackhead or oily skin, itís the best product for you. Shouhengda Blackhead Remover Mask is a comprehensive formulation that effectively clears oily skin, large pores and acne treatment and fit for people. It penetrates very strong, cleaning pores and dirt.', '../images/pd_13.jpg', 'shouhengda-blackhead-remover-cream-purifying', 36),(14, 'Thayers Alcohol-Free Rose Petal Witch Hazel with Aloe Vera', 7, 55, 5, 'The alcohol-free formula is a bestseller at Amazon, has over 10,000 reviews on Amazon, and a whopping 81 percent of customers give it five stars. This partivular formula of witch hazel is the higher ñ end version thatís un-distilled with more fancier skin care ingredients and higher quality.', '../images/pd_14.jpg', 'thayers-alcohol-free-rose-petal-witch-hazel', 52),(15, 'Vichy Ideal Soleil Hydrating Milk SPF 50', 5, 20, 0, 'Vichy Ideal Soleil Hydrating Milk SPF 50†is designed with simple yellow strap but still ensure the convenience and characteristics of the company. For texture, sunscreen has a slightly liquid cream, thanks to that advantage that easily absorbed into the skin, dry quickly. Especially do not cause any other greasy feel, oil balls on the skin like many kinds of sunscreen today. The Ideal Soleil range is formulated with lots of skin loving ingredients such as Hyaluronic Acid, Glycerin and Perlite, to help to hydrate, mattify, moisturise and revive the skin.', '../images/pd_15.png', 'vichy-ideal-soleil-hydrating-milk-spf-50', 20),(16, 'KIMUSE Cosmetics Long-lasting Waterproof Moisturizing', 2, 30, 10, 'Condition: 100% Brand new Longlasting lipstick. Colors:12 hot colors for you to choose. Fashion matte lipstick ,young and rich stunning hue. Long-lasting Easy to Wear', '../images/pd_16.jpg', 'kimuse-cosmetics-long-lasting-waterproof-moisturizing', 27),(17, 'MAC DEELIGHT Cremesheen Glass Lipgloss', 2, 50, 5, 'MAC Deelight Cremesheen Glass is a very soft and beauty color in your lips. It makes you look so natural and healthy. With MMLB shade, this lipstick suits a lot of skin color and perfect with olive-tan tone skin.', '../images/pd_17.jpg', 'mac-deelight-cremesheen-glass-lipgloss', 47),(18, 'NARS Audacious Lipstick Holidays Kiss Edition ñ Anita', 2, 10, 10, 'This is a product in the top 10 best NARS Holidays, NARS Audacious Lipstick is a modern lipstick so shamelessly seductive in touch and texture the sensation is audacious.', '../images/pd_18.jpg', 'nars-audacious-lipstick-holidays-kiss-edition-anita', 9);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `annshop`.`users` WRITE;
DELETE FROM `annshop`.`users`;
INSERT INTO `annshop`.`users` (`id`,`email`,`password`,`fullname`,`role`,`token`) VALUES (1, 'loitn148@gmail.com', 'ngocloi148', 'Tr?nh Ng?c L?i', 1, NULL);
UNLOCK TABLES;
COMMIT;
