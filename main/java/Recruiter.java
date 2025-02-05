public interface Recruiter {
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int num);
    public abstract boolean validRecruitPath(int rowRecruiter, int columnRecruiter,
                                             int rowRecruitee, int columnRecruitee);
}
