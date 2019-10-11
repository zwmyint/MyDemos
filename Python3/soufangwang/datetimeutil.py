from datetime import datetime

def format(timestamps):
    return datetime.fromtimestamp(timestamps/1e3).strftime('%y/%m/%d')