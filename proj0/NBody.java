public class NBody {
    public static double readRadius(String file)
    {
        In in = new In(file);
        in.readDouble();
        return in.readDouble();
    }

    public static Planet [] readPlanets(String file)
    {
        In in = new In(file);
        Planet [] ps = new Planet[in.readInt()];
        in.readDouble();
        for(int i=0; i<ps.length; ++i)
        {
            ps[i] = new Planet(in.readDouble(),in.readDouble(), in.readDouble(),
                        in.readDouble(), in.readDouble(), in.readString());
        }
        return ps;
    }
};
