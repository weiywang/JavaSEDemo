package HuaWei.Answer3;


import java.util.Set;
import java.util.TreeSet;

public class Plant {
    private Set<Ticket> tickets = new TreeSet<>();
    private String id;
    public Plant(String id){
        this.id = id;
    }
    public void add(Ticket ticket){
        Ticket temp = null;
        for(Ticket ticket1 : tickets){
            if(ticket1.getName().equals(ticket.getName())){
                temp = ticket1;
                break;
            }
            if(ticket1.getSeat().equals(ticket.getSeat())){
                temp = ticket1;
                break;
            }
        }
        if(temp != null){
            tickets.remove(temp);
        }
        tickets.add(ticket);
    }
    public void remove(Ticket ticket){
        tickets.remove(ticket);
    }

    @Override
    public boolean equals(Object obj) {
        return id.equals(((Plant)obj).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Ticket getTicket(String seat){
        for(Ticket ticket : tickets){
            if(ticket.getSeat().equals(seat)){
                return ticket;
            }
        }
        return null;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public String getId() {
        return id;
    }
}
