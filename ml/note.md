### 2024.11.21

I have some issue. when user provide expected throughput, that number can be
too high to be achived with given hardware. if so, the result is unreliable. So
there should be a way to constraint user to provide achivable performance value.

One thing that is possible is to train another model that takes hardware metric
and RPS to predict minimum and maximun performance value.
