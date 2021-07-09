import pandas_datareader.data as pd
import datetime as dt
from numpy import where 

start = dt.datetime(2015, 3, 1)
end = dt.datetime(2020, 3, 1)


df = pd.DataReader('AAPL', 'yahoo', start, end)

df['42ma'] = df['Close'].rolling(window = 42, min_periods = 0).mean()
df['252ma'] = df['Close'].rolling(window = 252, min_periods = 0).mean()
df['Diferencia'] = df['42ma'] - df['252ma']
df['Regime'] = where(df['Diferencia'] > 0, 1, 0)
df['Regime'] = where(df['Diferencia'] < 0, -1, df['Regime'])

df2 = df[['Close', '42ma', '252ma']].plot(grid = True)

print(df)
print(df2)