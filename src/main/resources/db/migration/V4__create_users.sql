CREATE TABLE public.users (
  use_id UUID NOT NULL,
  use_code BIGSERIAL,
  use_name VARCHAR(25) NOT NULL,
  use_password VARCHAR(128) NOT NULL,
  etb_id UUID NOT NULL,
  prf_id UUID NOT NULL,
  dst_id INTEGER NOT NULL,
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

COMMIT;

ALTER SEQUENCE public.users_use_code_seq
  INCREMENT 1 MINVALUE 0
  MAXVALUE 9223372036854775807 START 0
  RESTART 1 CACHE 1
  NO CYCLE;
