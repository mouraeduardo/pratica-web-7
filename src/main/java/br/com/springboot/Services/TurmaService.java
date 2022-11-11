package br.com.springboot.Services;

import java.util.ArrayList;
import java.util.List;

import br.com.springboot.Model.Aluno;
import br.com.springboot.Model.Turma;

public class TurmaService {
    

    private List<Turma> turmas = new ArrayList<>();

    public Turma createTurma(Turma turma){


        this.turmas.add(turma);

        return turma;
    }

    public Turma getTurmaById(int id){

        Turma turmaExisting = this.turmas.get(id);

        if (turmaExisting != null) {
            return turmaExisting;
        } else {
            return null;
        }
    }

    public List<Turma> getAllTurmas(){
        return this.turmas;
    }

    public String editTurma(Turma turma, int id){

        Turma existingTurma = getTurmaById(id);

        if (existingTurma != null) {
            existingTurma.semestre = turma.semestre;
            existingTurma.alunos = turma.alunos;
            existingTurma.disciplina = turma.disciplina;

            
            this.turmas.set(id, turma);

            return "Turma editada com sucesso";
        } else {
            return "Turma não existe";
        }
    }

    public String deleteTurma(int id){

        Turma existingTurma = getTurmaById(id);

        if (existingTurma != null) {
            this.turmas.remove(id);

            return "Turma removida com sucesso";
        } else {
            return "Turma não existe";
        }
    }

    public List<Aluno> getAllAlunos(int id){

        Turma existingTurma = this.getTurmaById(id);

        return existingTurma.alunos;
    }

    public Aluno createAluno(Aluno aluno, int id){

        Turma existingTurma = this.getTurmaById(id);
        
        existingTurma.alunos.add(aluno);

        this.turmas.set(id, existingTurma); //= existingTurma;// = existingTurma;

        return aluno;
    }

    public String deleteAluno(int idTurma, int matriculaAluno){

        Turma existingTurma = getTurmaById(idTurma);

        if (existingTurma != null) {

            for(int i = 0; i < existingTurma.alunos.size(); i++) {
                if (this.turmas.get(idTurma).alunos.get(i).matricula == matriculaAluno) {
                    
                    this.turmas.get(idTurma).alunos.remove(i);
                    return "Aluno removido com sucesso";
                }
            }
        }
        return "Turma ou aluno não encontrado(a)";
    }

}
