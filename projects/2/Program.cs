using System;

class Program
{
    static void Main(string[] args)
    {
        if (args.Length < 1)
        {
            Console.WriteLine("Usage: dotnet HelloDocker.dll <name> [<number>]");
            return;
        }

        string name = args[0]; // Get the name argument
        int count = 1; // Default count

        if (args.Length > 1 && int.TryParse(args[1], out int num))
        {
            count = num;
        }

        for (int i = 0; i < count; i++)
        {
            Console.WriteLine($"Hello, {name}!");
        }
    }
}
