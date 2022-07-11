class Zombie {
	int strength;
	int id;
	Zombie (int strength, int id) {
		this.strength = strength;
		this.id = id;
		System.out.println("Zombie number " + this.id + " is created with strength of " + this.strength);
	}
}

class ZombieCreator {
	int zombies_created;
	int max_number_of_zombies;
	ZombieCreator(int max_num_zombies) {
		this.zombies_created = 0;
		this.max_number_of_zombies = max_num_zombies;
	}
	public Zombie Create(int strength) {
		if (this.zombies_created >= max_number_of_zombies) {
			System.out.println("Maximum number of zombies reached. Returning null");
			return null;
		}
		this.zombies_created++;
		return new Zombie(strength, this.zombies_created);
	}
}

public class Factory_Mathod {

	public static void main(String[] args) {
		
		//Create a Factory for Zombie objects
		ZombieCreator zombieFactory = new ZombieCreator(5);
		
		//Try to create 7 zombies
		Zombie zombie1 =  zombieFactory.Create(100);
		Zombie zombie2 =  zombieFactory.Create(10);
		Zombie zombie3 =  zombieFactory.Create(200);
		Zombie zombie4 =  zombieFactory.Create(50);
		Zombie zombie5 =  zombieFactory.Create(90);
		Zombie zombie6 =  zombieFactory.Create(70);
		Zombie zombie7 =  zombieFactory.Create(300);
		
		//Check how many zombies are in the games
		int n_zombies = zombieFactory.zombies_created;
		System.out.println(n_zombies + " are roaming in the map so far.");
	
		//We can change the game setting to allow more zombies
		zombieFactory.max_number_of_zombies = 7;
		
		//Now creating 3 more zombies
		Zombie zombie8 =  zombieFactory.Create(90);
		Zombie zombie9 =  zombieFactory.Create(70);
		Zombie zombie10 =  zombieFactory.Create(300);
		
		//We can see that 2 more are allowed to be created but the last one is not created
	}
}


/* Result of the running the code

Zombie number 1 is created with strength of 100
Zombie number 2 is created with strength of 10
Zombie number 3 is created with strength of 200
Zombie number 4 is created with strength of 50
Zombie number 5 is created with strength of 90
Maximum number of zombies reached. Returning null
Maximum number of zombies reached. Returning null
5 are roaming in the map so far.
Zombie number 6 is created with strength of 90
Zombie number 7 is created with strength of 70
Maximum number of zombies reached. Returning null

 */

