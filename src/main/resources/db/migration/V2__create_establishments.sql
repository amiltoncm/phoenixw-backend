CREATE TABLE public.establishments (
  etb_id UUID NOT NULL,
  etb_code SERIAL,
  etb_name VARCHAR(70) NOT NULL,
  dst_it INTEGER DEFAULT 0 NOT NULL,
  CONSTRAINT pk_establishment PRIMARY KEY(etb_id),
  CONSTRAINT fk_dst_establishment FOREIGN KEY (dst_it)
    REFERENCES public.dom_status(dst_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
) ;

COMMENT ON TABLE public.establishments
IS 'ETB';

ALTER TABLE public.establishments
  OWNER TO amxsistemas;
