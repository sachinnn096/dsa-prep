package Heap.FAQ;


import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {


        int[] freq = new int[26];
        //counting the frequencies of character
        for( char c : tasks ){
            freq[ c - 'A' ]++;
        }

        Arrays.sort( freq );

        int maxFreq = freq[25];   //this force to follow a rigid structure
        int gadde = maxFreq - 1;
        //  A -- A -- A -- A                                -- gadde

        int idleSlots = gadde*n;

        for( int i = 24 ; i >=0 ; i-- ){
            idleSlots -= Math.min( gadde,freq[i] );
        }

        if( idleSlots > 0 ) return tasks.length + idleSlots;
        else return tasks.length;



    }
}

/*

It is completely natural to think that packing more tasks into the CPU's schedule might accidentally create a "traffic jam" that forces new idle time. However, mathematically, it is impossible for new idle time to occur once all the initial "chunks" are filled.

Here is the step-by-step breakdown of why the math guarantees zero idle time once the gaps are full.

1. The "Anchor" Task Defines the Spaces
In task scheduling with a cooldown (n), the task with the maximum frequency acts as the anchor. Let's say Task A appears 3 times, and the CPU cooldown is n = 2.

Task A forces the schedule to have at least this structure:
A [ idle ] [ idle ] A [ idle ] [ idle ] A

These gaps between the As are your chunks.

Number of chunks = Frequency of A - 1 (In this case, 2 chunks).

Minimum size of each chunk = n (In this case, 2 slots).

2. Every Other Task is Less Frequent
By definition, no other task in your queue appears more times than your anchor task A. If you have Task B (frequency 3) and Task C (frequency 2), you distribute them column by column into the chunks from left to right.

Because their frequency is less than or equal to A, you will run out of the task before you run out of chunks (including the final appended tasks). Therefore, a task like B or C will only appear once per chunk.

A [ B ] [ C ] A [ B ] [ C ] A [ B ]

Since the chunks are separated by A, the distance between the Bs is automatically guaranteed to be at least n. No idle time is needed to protect them.

3. The "Expanding Chunk" Rule (The Core Answer)
What if you have so many tasks that you completely fill the initial spaces and still have tasks left over? For example, you also need to schedule tasks D, E, F, and G.

This is the key to your question: The cooldown n is a minimum distance limit, not a maximum.

If you have extra tasks, you don't create new idle time—you just make the existing chunks bigger by inserting the extra tasks into them.

Original perfectly filled schedule:
A [B, C] A [B, C] A [B] (Distance between A's is 2, satisfying n=2)

Adding extra tasks (D, E, F, G):
A [B, C, D, E] A [B, C, F, G] A [B] (Distance between A's is now 4)

By stuffing more tasks into the gaps, you are pushing the identical tasks further apart. Since they were already safe from the cooldown limit, pushing them further apart makes them even safer. You will never accidentally violate the cooldown by adding different tasks into the gaps.

If you have enough tasks to completely fill the required idle slots dictated by the most frequent task, every single task can be executed back-to-back. The total time taken by the CPU is simply the total number of tasks in the queue.

*/