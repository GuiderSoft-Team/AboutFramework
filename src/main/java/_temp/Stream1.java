package _temp;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stream1 {

    List<Actor> actors = Arrays.asList(
            new Actor("A", 100),
            new Actor("B", 110),
            new Actor("C", 60),
            new Actor("Ç", 20),
            new Actor("D", 120),
            new Actor("E", 40),
            new Actor("F", 70),
            new Actor("G", 90),
            new Actor("Ğ", 200),
            new Actor("H", 140),
            new Actor("I", 10),
            new Actor("İ", 70)
    );

    @Test
    public void stream1(){
        long count = actors.stream().filter(a -> a.getFilmSayisi()>50).count();
        System.out.println(count);
    }

    @Test
    public void stream2(){
        actors.stream().sorted(Comparator.comparing(actor -> actor.getName())).forEach(System.out::println);
    }

    @Test
    public void stream3(){
        actors.stream()
                .sorted(Comparator.comparing(Actor::getFilmSayisi).thenComparing(Actor::getName))
                .toList()
                .forEach(System.out::println);
    }

    @Test
    public void stream4(){
        actors.stream().sorted(Comparator.comparing(Actor::getName)).toList().forEach(System.out::println);
        //actors.stream().sorted((a1, a2) -> a1.getName().compareTo(a2.getName())).toList().forEach(System.out::println);
    }



}

class Actor{
    private String name;
    private int filmSayisi;

    public Actor(String name, int filmSayisi) {
        this.name = name;
        this.filmSayisi = filmSayisi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFilmSayisi() {
        return filmSayisi;
    }

    public void setFilmSayisi(int filmSayisi) {
        this.filmSayisi = filmSayisi;
    }

    @Override
    public String toString() {
        return "name='" + name + ", filmSayisi=" + filmSayisi;
    }
}
