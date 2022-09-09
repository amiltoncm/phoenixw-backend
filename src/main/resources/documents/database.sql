-- Database: phoenixw

-- DROP DATABASE IF EXISTS phoenixw;

CREATE DATABASE phoenixw
    WITH
    OWNER = amxsistemas
    ENCODING = 'LATIN1'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE phoenixw
    IS 'Database for Phoenix Web ERP.';
