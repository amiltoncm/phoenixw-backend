ALTER TABLE public.users
  ADD CONSTRAINT fk_use_etb_id FOREIGN KEY (etb_id)
    REFERENCES public.establishments(etb_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;
