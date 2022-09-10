CREATE TABLE public.profiles (
  prf_id UUID NOT NULL,
  prf_code SERIAL,
  prf_name VARCHAR(50) NOT NULL,
  dst_id INTEGER NOT NULL,
  prf_created TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT now() NOT NULL,
  use_created UUID NOT NULL,
  prf_updated TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
  use_updated UUID NOT NULL,
  CONSTRAINT idx_profile UNIQUE(prf_code),
  CONSTRAINT pk_profile PRIMARY KEY(prf_id),
  CONSTRAINT unq_prf_name UNIQUE(prf_name),
  CONSTRAINT fk_prf_dst_id FOREIGN KEY (dst_id)
    REFERENCES public.dom_status(dst_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT fk_prf_use_created FOREIGN KEY (use_created)
    REFERENCES public.users(use_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT fk_prf_use_updated FOREIGN KEY (use_updated)
    REFERENCES public.users(use_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
) ;

COMMENT ON TABLE public.profiles
IS 'PRF';

ALTER TABLE public.profiles
  OWNER TO amxsistemas;
