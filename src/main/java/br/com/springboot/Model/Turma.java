package br.com.springboot.Model;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Turma {

    public int codigo;
    public String disciplina;
    public int semestre;
    public List<Aluno> alunos;
}
