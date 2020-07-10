package dev.ihm.options;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import dev.exception.PlatException;

@Service
@Profile("terminer")
public class OptionTerminer implements IOptionMenu {
	
	
    @Override
    public String getTitre() {
        return "Terminer";
    }

    @Override
    public void executer() {
        throw new PlatException("Aurevoir");
    }
}
