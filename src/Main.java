import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    /**
     * Start Application
     * @param args
     */
    public static void main(String[] args) {
        Curso cursoA = new Curso();
        cursoA.setTitulo("Java Avançado");
        cursoA.setDescricao("Aprenda Java e ingresse no mercado de trabalho ");
        cursoA.setCargaHoraria(40);
        Curso cursoB = new Curso();
        cursoB.setTitulo("Java Spring");
        cursoB.setDescricao("Aprenda Esse framework e se profissionalize ");
        cursoB.setCargaHoraria(40);
        System.out.println(cursoA);
        System.out.println(cursoB);

        Mentoria mentoriaA = new Mentoria();
        mentoriaA.setTitulo("Mentoria SOLID");
        mentoriaA.setDescricao("Aprenda boas práticas SOLID com a Mentora");
        mentoriaA.setData(LocalDate.now());
        System.out.println(mentoriaA);

    }
}
