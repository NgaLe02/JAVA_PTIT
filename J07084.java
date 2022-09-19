package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class J07084 implements Comparable<J07084> {

    private String name, batDau, ketThuc;
    private Date datein, dateout;
    private long time;

    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public J07084(String name, String batDau, String ketThuc) {
        this.name = name;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
    }

    public void setTime() throws ParseException {
        Date startTime = date.parse(batDau);
        Date endTime = date.parse(ketThuc);
        this.time = (endTime.getTime() - startTime.getTime()) / (1000 * 60);
    }

    @Override
    public String toString() {
        return name + " " + time;
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("ONLINE.in"));

        int t = Integer.parseInt(sc.nextLine());
        ArrayList<J07084> ds = new ArrayList<>();
        while (t-- > 0) {
            ds.add(new J07084(sc.nextLine(), sc.nextLine(), sc.nextLine()));
            ds.get(ds.size() - 1).setTime();
        }

        Collections.sort(ds);
        for (J07084 x : ds) {
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(J07084 t) {
        if (this.time == t.time) {
            return this.name.compareTo(t.name);
        }
        if (t.time - this.time > 0) {
            return 1;
        }
        return -1;
    }
}
