import java.util.*;

public class Estimator {
    
    public static Scanner in = new Scanner(System.in);
    public static int A_votes;
    public static int B_votes;
    public static double reporting;
    
    public static void main(String[] args) {
	System.out.println("Votes for candidate A: ");
	A_votes = Integer.parseInt(in.next());
	System.out.println("Votes for candidate B: ");
	B_votes = Integer.parseInt(in.next());
	System.out.println("Percent reporting: ");
	reporting = Double.parseDouble(in.next()) / 100;
	
	boolean A_favored = A_votes > B_votes;
	int currentVotes = A_votes + B_votes;
	double totalVoters = currentVotes / reporting;
	double minVotes = totalVoters / 2;
	double notVoted = totalVoters - currentVotes;
	
	System.out.println();
	System.out.println("Vote difference: " + Math.abs(A_votes - B_votes));
	System.out.println("Approximate uncounted votes: " + Math.round(notVoted));
	System.out.println("Approximate minimum votes to win: " + Math.round(minVotes));
	System.out.println();
	System.out.println("Candidate " + ((A_favored) ? "A" : "B") + " is favored");
	
	if(A_favored && B_votes + notVoted < A_votes) {
	    System.out.println("Candidate A will win");
	    return;
	}
	if(!A_favored && A_votes + notVoted < B_votes) {
	    System.out.println("Candidate B will win");
	    return;
	}
	System.out.println("Winner is undecided");
	return;
    }
}
