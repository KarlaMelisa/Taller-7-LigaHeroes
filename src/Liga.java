import java.util.ArrayList;

public class Liga {
    private ArrayList<Heroe> heroes;

    public Liga() {
        heroes = new ArrayList<>();
    }

    public ArrayList<Heroe> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Heroe> heroes) {
        this.heroes = heroes;
    }

    @Override
    public String toString() {
        return "Liga De La Justicia\n" +
                "Heroes: " + heroes;
    }
}
