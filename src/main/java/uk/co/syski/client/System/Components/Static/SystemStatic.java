package uk.co.syski.client.System.Components.Static;

public class SystemStatic
{
    private int id;
    private String model;
    private String manufacturer;
    private String type;
    private String hostName;

    //Getters
    public int getID()
    {
        return id;
    }

    public String getModel()
    {
        return model;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getType()
    {
        return type;
    }

    public String getHostName()
    {
        return hostName;
    }

    //Setters
    public void setID(int ID)
    {
        id = ID;
    }

    public void setModel(String m)
    {
        model = m;
    }

    public void setManufacturer(String m)
    {
        manufacturer = m;
    }

    //For when the type is defined as an int: https://docs.microsoft.com/en-us/windows/desktop/cimwin32prov/win32-systemenclosure @ChassisTypes
    public void setType(int t)
    {
        type = getTypeFromInt(t);
    }

    public void setType(String t)
    {
        type = t;
    }

    public void setHostName(String hn)
    {
        hostName = hn;
    }

    //Convert ChassisTypes int to a string type
    private String getTypeFromInt(int i)
    {
        switch (i)
        {
            case 1: return "Other";
            case 2: return "Unknown";
            case 3: return "Desktop";
            case 4: return "Low Profile Desktop";
            case 5: return "Pizza Box";
            case 6: return "Mini Tower";
            case 7: return "Tower";
            case 8: return "Portable";
            case 9: return "Laptop";
            case 10: return "Notebook";
            case 11: return "Hand Held";
            case 12: return "Docking Station";
            case 13: return "All in One";
            case 14: return "Sub Notebook";
            case 15: return "Space-Saving";
            case 16: return "Lunch Box";
            case 17: return "Main System Chassis";
            case 18: return "Expansion Chassis";
            case 19: return "SubChassis";
            case 20: return "Bus Expansion Chassis";
            case 21: return "Peripheral Chassis";
            case 22: return "Storage Chassis";
            case 23: return "Rack Mount Chassis";
            case 24: return "Sealed-Case PC";
            default: return "Unknown";
        }
    }
}
