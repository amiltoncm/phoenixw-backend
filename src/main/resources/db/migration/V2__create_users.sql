CREATE TABLE public.users (
  use_id UUID NOT NULL,
  use_code BIGSERIAL,
  use_name VARCHAR(25) NOT NULL,
  use_password VARCHAR(128) NOT NULL,
  etb_id UUID,
  prf_id UUID,
  dst_id INTEGER NOT NULL,
  use_created TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT now() NOT NULL,
  use_updated TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT pk_user PRIMARY KEY(use_id),
  CONSTRAINT unq_use_name UNIQUE(use_name),
  CONSTRAINT fk_use_dst_id FOREIGN KEY (dst_id)
    REFERENCES public.dom_status(dst_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT fk_use_etb_id FOREIGN KEY (etb_id)
    REFERENCES public.establishments(etb_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT fk_use_prf_id FOREIGN KEY (prf_id)
    REFERENCES public.profiles(prf_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
) ;

COMMENT ON TABLE public.users
IS 'USE';

CREATE INDEX idx_user ON public.users
  USING btree (use_code);

ALTER TABLE public.users
  OWNER TO amxsistemas;
