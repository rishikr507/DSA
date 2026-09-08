Select w1.id 
from weather as w1
join weather as w2
on  DATEDIFF(w1.recorddate, w2.recorddate) = 1
    and w1.temperature > w2.temperature;