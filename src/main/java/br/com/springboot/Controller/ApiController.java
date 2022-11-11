package br.com.springboot.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.Model.Aluno;
import br.com.springboot.Model.Turma;
import br.com.springboot.Services.TurmaService;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    private TurmaService turmaService = new TurmaService();

    @GetMapping("/turma")
    public List<Turma> GetAllTurmas(){

        List<Turma> turmas = turmaService.getAllTurmas();

        return turmas;
    }


    @GetMapping("/turma/{id}")
    public Turma GetTurmaById(@PathVariable int id){

        Turma turmas = turmaService.getTurmaById(id);

        return turmas;
    }

    @PostMapping("/turma")
    public Turma CreateTurma(@RequestBody Turma turma){

        Turma createdTurma = this.turmaService.createTurma(turma);

        return createdTurma;
    }

    @PutMapping("/turma/{id}")
    public String CreateTurma(@PathVariable int id, @RequestBody Turma turma){

        String createdTurma = this.turmaService.editTurma(turma, id);

        return createdTurma;
    }

    @DeleteMapping("/turma/{id}")
    public String DeleteTurma(@PathVariable int id){

        String message = this.turmaService.deleteTurma(id);

        return message;
    }

    @GetMapping("/turma/{id}/alunos")
    public List<Aluno> GetAllAlunos(@PathVariable int id){

        System.out.println("chegouy aqui");
        return this.turmaService.getAllAlunos(id);
    }

    @PostMapping("/turma/{id}/alunos")
    public Aluno CreateAluno(@RequestBody Aluno aluno, @PathVariable int id){

        Aluno newAluno = new Aluno();

        newAluno.setMatricula(aluno.getMatricula());
        newAluno.setEmail(aluno.getEmail());
        newAluno.setNome(aluno.getNome());

        Aluno createAluno = this.turmaService.createAluno(newAluno, id);

        return createAluno;
    }

    @DeleteMapping("/turma/{id}/alunos/{matricula}")
    public String DeleteAluno(@PathVariable int id,@PathVariable int matricula){

        String message = this.turmaService.deleteAluno(id, matricula);

        return message;
    }
}
