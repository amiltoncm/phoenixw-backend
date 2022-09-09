CREATE TABLE public.profiles (
  prf_id UUID NOT NULL,
  prf_code SERIAL,
  prf_name VARCHAR(50) NOT NULL,
  dst_id INTEGER NOT NULL,
  CONSTRAINT idx_profile UNIQUE(prf_code),
  CONSTRAINT pk_profile PRIMARY KEY(prf_id),
  CONSTRAINT unq_prf_name UNIQUE(prf_name),
  CONSTRAINT fk_prf_dst_id FOREIGN KEY (dst_id)
    REFERENCES public.dom_status(dst_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
) ;

COMMENT ON TABLE public.profiles
IS 'PRF';

ALTER TABLE public.profiles
  OWNER TO amxsistemas;
