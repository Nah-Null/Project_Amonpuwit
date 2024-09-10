import tkinter as tk

def on_click(key):
    if key == '=':
        try:
            result = str(eval(display.get()))
            display.delete(0, tk.END)
            display.insert(tk.END, result)
        except:
            display.delete(0, tk.END)
            display.insert(tk.END, "Error")
    elif key == 'C':
        display.delete(0, tk.END)
    else:
        display.insert(tk.END, key)

def on_key(event):
    valid_keys = '0123456789+-*/=C'
    if event.char in valid_keys:
        on_click(event.char)
    elif event.keysym == 'Return':
        on_click('=')
    elif event.keysym == 'Escape':
        on_click('C')

# Create the main window
root = tk.Tk()
root.title("Calculator")
root.geometry("400x400")

# Bind the keyboard keys to the on_key function
root.bind('<Key>', on_key)

# Create the display entry
display = tk.Entry(root, font=("Arial", 18), bd=10, insertwidth=2, width=15, borderwidth=4)
display.grid(row=0, column=0, columnspan=4)

# Define the buttons
buttons = [
    '7', '8', '9', '/',
    '4', '5', '6', '*',
    '1', '2', '3', '-',
    'C', '0', '=', '+'
]

# Create and position buttons
row_value = 1
col_value = 0

for button in buttons:
    action = lambda x=button: on_click(x)
    tk.Button(root, text=button, font=("Arial", 18), padx=20, pady=20, command=action).grid(row=row_value, column=col_value)
    col_value += 1
    if col_value > 3:
        col_value = 0
        row_value += 1

# Start the main loop
root.mainloop()
