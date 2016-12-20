/**
 * Created by Administrator on 19/12/2016.
 */
public class Calculator
{

    int add(String input)
    {
        if(input.equals(""))
        {
            return 0;
        }

        else
        {
            try
            {
                //Splits string if there is whitespace(\\s*) OR (|) a new line OR ()(\\r?\\n) and a comma(,)
                String[] s = input.split("\\s*(\\r?\\n|,|\\s)\\s*");
                int total = 0;
                for (String number : s)
                {
                    int num = Integer.parseInt(number);

                    if(num < 0)
                    {
                        throw new IllegalArgumentException("Negatives not allowed!");

                    }

                    else if(num>=1000)
                        {
                            num=1000;

                        }

                    total=total+num;
                }

            return total;
            }
            catch (NumberFormatException nfe)
            {
                return 1;
            }
        }


    }

}
