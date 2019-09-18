package HuaWei.Answer3;

public class Ticket implements Comparable<Ticket>{
    private Plant plant;
    private String seat;
    private String name;
    public Ticket(String pid, String seat, String name){
        this.plant = PlantFactory.getPlant(pid);
        this.seat = seat;
        this.name = name;
    }

    public void change(Ticket ticket){
        plant.remove(this);
        plant.add(ticket);
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.seat.compareTo(o.getSeat());
    }

    @Override
    public String toString() {
        return plant.getId()+ "," + seat + "," + name;
    }
}
