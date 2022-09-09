CREATE TABLE public.dom_status (
  dst_id INTEGER NOT NULL,
  dst_name VARCHAR(10) NOT NULL,
  CONSTRAINT pk_dom_status PRIMARY KEY(dst_id)
) ;

COMMENT ON TABLE public.dom_status
IS 'DST';

ALTER TABLE public.dom_status
  OWNER TO amxsistemas;


