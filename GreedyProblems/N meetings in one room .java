class Meeting{
    int start;
    int end;
    int pos;
    Meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class comp implements Comparator<Meeting>{

    public int compare(Meeting o1, Meeting o2){
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1;
    }
}
class Solution {
    public int maxMeetings(int n, int start[], int end[]) {
        ArrayList<Meeting> meet = new ArrayList<>();
        for(int i=0;i<n;i++){
            meet.add(new Meeting(start[i],end[i],i+1));
        }
        comp c = new comp();
        Collections.sort(meet,c);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(meet.get(0).pos);
        int count = 1;
        int limit = meet.get(0).end;
        for(int i=1;i<n;i++){
            if(meet.get(i).start > limit){
                limit = meet.get(i).end;
                count++;
                temp.add(meet.get(i).pos);
            }
        }
        return count;

    }
}
