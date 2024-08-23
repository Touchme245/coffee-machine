INSERT INTO public.coffee (name, price) VALUES
    ('Эспрессо', 100.00),
    ('Американо', 120.00),
    ('Капучино', 150.00);

INSERT INTO public.recipe (amount, name) VALUES
    (10.00, 'Зерна'),
    (12.00, 'Вода'),
    (15.00, 'Молоко'),
    (4.00, 'Сироп');

INSERT INTO public.coffee_recipes (coffee_id, recipes_id) VALUES
    (1, 1),  -- Эспрессо
    (2, 2),  -- Американо
    (3, 3),  -- Капучино
    (3, 4);  -- Капучино

INSERT INTO public.ingredients (name, amount) VALUES
    ('Зерна', 15.0),
    ('Вода', 100.0),
    ('Молоко', 50.0),
    ('Сироп', 20.0);