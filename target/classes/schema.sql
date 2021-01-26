drop table if exist tbl_geolocation;

create table tbl_geolocation (
    id INTEGER NOT NULL AUTO_INCREMENT,
    timeDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ipAddress VARCHAR(16) NOT NULL,
    location VARCHAR(100),
    PRIMARY KEY (id)
);