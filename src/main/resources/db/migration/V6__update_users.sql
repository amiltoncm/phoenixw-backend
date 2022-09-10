ALTER TABLE public.users
  ADD CONSTRAINT fk_use_prf_id FOREIGN KEY (prf_id)
    REFERENCES public.profiles(prf_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;
