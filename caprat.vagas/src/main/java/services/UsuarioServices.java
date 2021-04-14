package services;

import java.util.List;

import models.UsuarioCurriculo;

import java.util.Arrays;

public class UsuarioServices {
	
	public List<UsuarioCurriculo> getCurriculos(){
		
		return Arrays.asList(new UsuarioCurriculo(0, 0, "A", "A", "A", "A", "A", "A", "A", "A", "A", "A"),
				new UsuarioCurriculo(0, 0, "B", "B", "B", "B", "B", "B", "B", "B", "B", "B"),
				new UsuarioCurriculo(0, 0, "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"));
		
	}
	
}
