package daojpa;

import modelo.Visualizacao;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.Period;

public class TriggerListener {
    @PrePersist
    public void exibirmsg1(Object obj) throws Exception{
        System.out.println(" @Prepersist... " + obj.getClass().getSimpleName());
    }
    @PostLoad
    public void exibirmsg2(Object obj) throws  Exception{
        System.out.println(" @PostLoad... " + obj.getClass().getSimpleName());
        if(obj instanceof Visualizacao){
            Visualizacao v = (Visualizacao) obj;
            System.out.println(" idade =" + v.getIdade());
            int idade = calcularIdade( v );
            v.setIdade(idade);
            System.out.println("idade calculada=" + idade);
        }
    }
    //============================================================
    public int calcularIdade( Visualizacao v){
        LocalDate hoje = LocalDate.now();
        Period per = Period.between(LocalDate.parse(v.getdatahora()), hoje);
        int idade = per.getYears();
        return idade;
    }

}
