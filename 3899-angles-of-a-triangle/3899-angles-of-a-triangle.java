class Solution {
    public double[] internalAngles(int[] sides) {
        double a = sides[0];
        double b = sides[1];
        double c = sides [2];

        // check triangle validity
        // in triangle sum of two sides is always greater than the 3rd side

        if(a+b<=c|| b+c<=a || c+a<=b){
            return new double[]{};
        }

        // for angles => cosine = (b^2 +c^2 -a^2) / 2bc

        double A = Math.toDegrees(Math.acos((b*b + c*c - a*a) / (2*b*c)));
        double B = Math.toDegrees(Math.acos((a*a + c*c - b*b) / (2*a*c)));
        double C = Math.toDegrees(Math.acos((a*a + b*b - c*c) / (2*a*b)));

        double res[] =  new double[]{A, B, C};

        Arrays.sort(res);
        return res;
    }
}