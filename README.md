Personal Finance Manager

GitHub Project Repository: https://github.com/Pizzalilla/Personal-Financial-Manager/tree/master 

I decided to make a Personal Finance Manager using Java. As a student, I have to responsibly manage my finances and make sure to not overspend. Especially as a student living in Sydney, it's easy to go and spend on unnecessary products leading to overspending. So I thought through the things we have learnt it is an ample amount of knowledge to be able to build this application, which is designed to help users manage their personal finances by tracking income and expenses, categorizing transactions, and providing alerts when spending exceeds a set budget. It supports basic features like adding transactions, listing all transactions, generating summaries by category, and displaying monthly transaction reports.

Features:
  - Add Transactions: Enter details such as type (income or expense), amount, description, date, and category.
  - List Transactions: View a chronological list of all transactions.
  - Summaries by Category: Get financial summaries categorized by transaction type.
  - Monthly Reports: Generate detailed reports for transactions in a specified month.
  - Set Budget Limit: Set and adjust the budget limit to receive alerts when expenses exceed this threshold.
  - Data Persistence: Transactions are saved to and loaded from a file, ensuring data persistence across sessions.

There were some problems that I ran into, but I solved most of them. There is still one thing I wish I could have added, which is having a go back to menu option. I tried to do this but it led to errors, so I decided to leave it out. Along with that, I had some difficulties with the methods that had variables relating to dates. For this I did have to use stackoverflow and watch some youtube videos, aside from that the work was done by me from the knowledge I have. Below I have included some of my thought processes and images to show proof of my work.

This is not a full on website, however, it can store your personal information you input in for future use. I used IntelliJ to run the program, and it was able to save my progress even after I exited the code.  

For the first git push, I completed the FinanceManager Java file and coded the methods in it. Then the second one I finished the transaction file and for the third one I finished the finance app file. After I had finished coding it, I did some test runs on the code and tried to find problems with it. After this run, I was able to find a few problems, which included:
  - When the user is picking an option, if the input is not part of the options, it would end the code.
  - When the user picks the transaction option, 
  - If the person spells income or expense wrong. It would just continue the code.
  - If the person doesn't enter the date in the correct format, there were no precautions for this and it would continue.
  - Then for the category, if in 1 input the person enters Amazon and the other amazon, it is counted as 2 different categories.
  - Then when listing transactions it did not return it in chronological order.
  - The overspending feature wasn't implemented properly.
