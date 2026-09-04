/*In a remote valley lies an ancient Echo Cave believed to possess magical 
acoustic powers. Deep within this cave, there are a series of chambers, 
each inscribed with a single word on its wall. When a traveler walks through 
the chambers and speaks aloud each word in order, the cave returns a mysterious 
palindromic echo of the spoken words.

This echo follows a strict mystical pattern:

The first chamber echoes its word,
Then allows the echo from the rest of the chambers to resonate,
And finally repeats its word again on the way back.

In essence, the cave builds a symmetric sequence of words by recursively echoing 
the words forward and then backward, wrapping each recursive step in 
the first word of the current sequence.

Your task is to simulate this word-based echo using recursion.

Sample TestCase:
input=hello world
output=hello world world hello


import java.util.*;

public class EchoCave 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

       //wRITE YOUR CODE HERE
    }

    // Recursive method to build the symmetric echo
    static List<String> echoWords(String[] words, int index) 
	{
        //WRITE YOUR CODE HERE
    }
}
    */
   import java.util.*;

public class EchoCave
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] words = input.split(" ");

        List<String> result = echoWords(words, 0);

        for (int i = 0; i < result.size(); i++)
        {
            System.out.print(result.get(i));
            if (i != result.size() - 1)
                System.out.print(" ");
        }
    }

    // Recursive method to build the symmetric echo
    static List<String> echoWords(String[] words, int index)
    {
        List<String> result = new ArrayList<>();

        if (index == words.length)
            return result;

        result.add(words[index]);
        result.addAll(echoWords(words, index + 1));
        result.add(words[index]);

        return result;
    }
}