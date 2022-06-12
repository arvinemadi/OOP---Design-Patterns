/*
An underground railway system is keeping track of customer travel times between different stations. They are using this data to calculate the average time it takes to travel from one station to another.

Implement the UndergroundSystem class:

- void checkIn(int id, string stationName, int t)
	A customer with a card ID equal to id, checks in at the station stationName at time t.
	A customer can only be checked into one place at a time.
- void checkOut(int id, string stationName, int t)
	A customer with a card ID equal to id, checks out from the station stationName at time t.
- double getAverageTime(string startStation, string endStation)
	Returns the average time it takes to travel from startStation to endStation.
	The average time is computed from all the previous traveling times from startStation to endStation that happened directly, meaning a check in at startStation followed by a check out from endStation.
	The time it takes to travel from startStation to endStation may be different from the time it takes to travel from endStation to startStation.
	There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.

You may assume all calls to the checkIn and checkOut methods are consistent. If a customer checks in at time t1 then checks out at time t2, then t1 < t2. All events happen in chronological order.

Example 1:

Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]

Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]

*/

class UndergroundSystem {
    public UndergroundSystem() {
        transit     = new HashMap<>();
        Trips       = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
            transit.put(id, new Value(stationName, t));
    return;
    }
    
    public void checkOut(int id, String stationName, int t) {
        int time = t - (int)transit.get(id).value2;
        Key k = new Key((String)transit.get(id).value1, stationName);
        if(!Trips.containsKey(k))           Trips.put(k, new Value(time, 1));
        else {
            Value newValue = Trips.get(k);
            newValue.value1  = (int)newValue.value1 + time;
            newValue.value2  = (int)newValue.value2 + 1;
            Trips.put(k, newValue);
        }
    return;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Key k = new Key(startStation, endStation);
        return (double)(int)Trips.get(k).value1 / (int)Trips.get(k).value2;
    }
    
    Map<Integer, Value> transit;
    Map<Key, Value>   Trips;
    
    class Key<K1, K2>
                {
                    public K1 key1;
                    public K2 key2;
                    public Key(K1 key1, K2 key2)
                    {
                        this.key1 = key1;
                        this.key2 = key2;
                    }
                    @Override
                    public boolean equals(Object o)
                    {
                        if (this == o)                                                  return true;
                        if (o == null || getClass() != o.getClass())                    return false;
                        Key key = (Key) o;
                        if (key1 != null ? !key1.equals(key.key1) : key.key1 != null)   return false;
                        if (key2 != null ? !key2.equals(key.key2) : key.key2 != null)   return false;
                        return true;
                    }

                    @Override
                    public int hashCode()
                    {
                        int result = key1 != null ? key1.hashCode() : 0;
                        result = 11 * result + (key2 != null ? key2.hashCode() : 0);
                        return result;
                    }
                }
    class Value<V1, V2>
                {
                    public V1 value1;
                    public V2 value2;
                    public Value(V1 value1, V2 value2)
                    {
                        this.value1 = value1;
                        this.value2 = value2;
                    }
                }
}