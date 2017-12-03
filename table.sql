CREATE TABLE 'user_table' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'email' varchar(255) NOT NULL,
  'password' varchar(255) NOT NULL,
  'user_name' varchar(20) NOT NULL,
  'zip_code' int(5) NOT NULL,
  'dog_sitter' tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY ('id')
);
