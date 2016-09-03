package br.com.uninove.fabricaapp.espirometria.controllers;

import models.Pessoa;
import models.ResultadoValidacao;

/**
 *
 * @author Guilherme & Junior
 */
public interface ItemValidacao {
    
    public ResultadoValidacao validar(Pessoa pessoa);   
    
}
