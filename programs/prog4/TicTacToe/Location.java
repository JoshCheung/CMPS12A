//Joshua Cheung
//Cmps-12a
// Location class for TTT


public class Location 
{
    public int levels;
    public int row;
    public int col;
    
    public Location(int levels, int row, int col)
    {
        this.levels = levels;
        this.row = row;
        this.col = col;
    }
    
    public String toString()
    {
        return "level = " + levels + ", row = " + row + ", col = " + col;
    }
}


