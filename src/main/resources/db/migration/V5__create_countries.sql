CREATE TABLE public.countries (
  con_id UUID NOT NULL,
  con_code INTEGER NOT NULL,
  con_name VARCHAR(75) NOT NULL,
  con_iso2 CHAR(2),
  con_iso3 CHAR(3),
  dst_id INTEGER DEFAULT 1 NOT NULL,
  CONSTRAINT pk_country PRIMARY KEY(con_id),
  CONSTRAINT unq_country UNIQUE(con_name),
  CONSTRAINT fk_con_dst_id FOREIGN KEY (dst_id)
    REFERENCES public.dom_status(dst_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
) ;

CREATE INDEX idx_country ON public.countries
  USING btree (con_code);

ALTER TABLE public.countries
  OWNER TO amxsistemas;
