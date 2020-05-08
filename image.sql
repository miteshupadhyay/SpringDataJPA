use mydb

create TABLE image(
	id BIGINT NOT NULL,
	name varchar(100) NOT NULL,
	data LONGBLOB NOT NULL,
	PRIMARY KEY(id)
);

drop table image