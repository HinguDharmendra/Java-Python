import java.util.Date;

public class Generate_Date 
{
    public static java.util.LinkedList searchBetweenDates(java.util.Date startDate, java.util.Date endDate) 
    {
        java.util.Date begin = new Date(startDate.getTime());
        java.util.LinkedList list = new java.util.LinkedList();
        list.add(new Date(begin.getTime()));
		
        while(begin.compareTo(endDate)<0)
        {
            begin = new Date(begin.getTime() + 86400000);
            list.add(new Date(begin.getTime()));
        }
		
        return list;
    }

    public static void main(String[] args) throws Exception   
    {   
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Enter the Start Date: dd/mm/yyyy");
        String begin = new String();
        begin = input.nextLine();

        System.out.println("Enter the End Date: dd/mm/yyyy");
        String end = new String();
        end = input.nextLine();

        java.util.LinkedList hitList = searchBetweenDates(
        	    new java.text.SimpleDateFormat("dd/MM/yyyy").parse(begin),
        	    new java.text.SimpleDateFormat("dd/MM/yyyy").parse(end));

        String[] comboDates = new String[hitList.size()];
        for(int i=0; i<hitList.size(); i++)
            comboDates[i] = new java.text.SimpleDateFormat("dd/MM/yyyy - E").format(((java.util.Date)hitList.get(i)));
        
        for(int i=0; i<comboDates.length; i++)
            System.out.println(comboDates[i]);
    
        input.close();
    }
}
