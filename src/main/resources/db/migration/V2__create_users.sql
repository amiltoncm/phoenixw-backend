CREATE TABLE public.users (
  use_id UUID NOT NULL,
  use_code BIGSERIAL NOT NULL,
  use_name VARCHAR(25) NOT NULL,
  use_password VARCHAR(128) NOT NULL,
  use_email VARCHAR(128) NOT NULL,
  etb_id UUID,
  prf_id UUID NOT NULL,
  dst_id INTEGER NOT NULL,
  use_created TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT now() NOT NULL,
  use_updated TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT pk_user PRIMARY KEY(use_id),
  CONSTRAINT unq_use_name UNIQUE(use_name),
  CONSTRAINT fk_use_dst_id FOREIGN KEY (dst_id)
    REFERENCES public.dom_status(dst_id)
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
