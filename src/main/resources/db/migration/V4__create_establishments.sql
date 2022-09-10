CREATE TABLE public.establishments (
  etb_id UUID NOT NULL,
  etb_code SERIAL,
  etb_name VARCHAR(70) NOT NULL,
  dst_id INTEGER DEFAULT 0 NOT NULL,
  etb_created TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT now() NOT NULL,
  use_created UUID NOT NULL,
  etb_updated TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
  use_updated UUID NOT NULL,
  CONSTRAINT pk_establishment PRIMARY KEY(etb_id),
  CONSTRAINT fk_dst_establishment FOREIGN KEY (dst_id)
    REFERENCES public.dom_status(dst_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT fk_etb_created FOREIGN KEY (use_created)
    REFERENCES public.users(use_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT fk_etb_updated FOREIGN KEY (use_updated)
    REFERENCES public.users(use_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
) ;

COMMENT ON TABLE public.establishments
IS 'ETB';

ALTER TABLE public.establishments
  OWNER TO amxsistemas;
